package com.example.evi.mobtest;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.FacebookSdk;
import com.facebook.appevents.*;
import com.facebook.share.model.AppInviteContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.AppInviteDialog;
import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;

import bolts.AppLinks;

public class Facebook extends AppCompatActivity {
    private Button btnShare ,invite;
    private ShareDialog shareDialog;
    private String appLinkUrl, previewImageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        shareDialog = new ShareDialog(this);
        invite=(Button)findViewById(R.id.invite) ;
        FacebookSdk.sdkInitialize(getApplicationContext());
        //ShareLinkContent content = new ShareLinkContent.Builder()
           //     .setContentUrl(Uri.parse("https://developers.facebook.com"))
              //  .build();





        /*LikeView likeView = (LikeView) findViewById(R.id.likeView);
        likeView.setObjectIdAndType(
                "https://www.facebook.com/FacebookDevelopers",
                LikeView.ObjectType.PAGE);*/
        btnShare = (Button) findViewById(R.id.fb_share_button);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                            .setContentTitle("Hello Guys")
                            .setContentDescription(
                                    "Coder who learned and share")
                            .setContentUrl(Uri.parse("http://instinctcoder.com"))
                            .setImageUrl(Uri.parse("https://scontent-sin1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/12936641_845624472216348_1810921572759298872_n.jpg?oh=72421b8fa60d05e68c6fedbb824adfbf&oe=577949AA"))
                            .build()
                            ;

                    shareDialog.show(linkContent);
                }
            }
        });
//Like
        LikeView likeView = (LikeView) findViewById(R.id.likeView);
        likeView.setLikeViewStyle(LikeView.Style.STANDARD);
        likeView.setAuxiliaryViewPosition(LikeView.AuxiliaryViewPosition.INLINE);

        likeView.setObjectIdAndType ("http://instinctcoder.com", LikeView.ObjectType.PAGE);


        ShareButton fbShareButton = (ShareButton) findViewById(R.id.fb_share_button);
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentTitle("Μοιραστείτε την εφαρμογή μας")
                .setContentDescription(
                        "Κανείς στο περιθώριο")
                .setContentUrl(Uri.parse("http://instinctcoder.com"))
                .setImageUrl(Uri.parse("https://scontent-sin1-1.xx.fbcdn.net/hphotos-xap1/v/t1.0-9/12936641_845624472216348_1810921572759298872_n.jpg?oh=72421b8fa60d05e68c6fedbb824adfbf&oe=577949AA"))
                .build();
        fbShareButton.setShareContent(content);

        invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appLinkUrl = "https://www.example.com/myapplink";
                previewImageUrl = "https://www.example.com/my_invite_image.jpg";
//"";
                if (AppInviteDialog.canShow()) {
                    AppInviteContent content = new AppInviteContent.Builder()
                            .setApplinkUrl(appLinkUrl)
                            .setPreviewImageUrl(previewImageUrl)
                            .build();
                    AppInviteDialog.show(Facebook.this,content);
                }
                Uri targetUrl = AppLinks.getTargetUrlFromInboundIntent(Facebook.this, getIntent());
                if (targetUrl != null) {
                    Log.i("Activity", "App Link Target URL: " + targetUrl.toString());
                }

            }
        });
    }
}
