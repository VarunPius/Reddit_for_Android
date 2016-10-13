package varunpius.redditclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by VarunPius on 10/12/2016.
 */

public class RedditPostAdapter extends ArrayAdapter<RedditPost> {
    public RedditPostAdapter(Context context, ArrayList<RedditPost> posts){
        super(context, 0, posts);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        RedditPost post = getItem(position);

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_reddit_post, parent, false);
        }

        //Lookup views within the layout
        TextView tvUpvotes = (TextView) convertView.findViewById(R.id.tvUpvotes);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvDomain = (TextView) convertView.findViewById(R.id.tvDomain);
        TextView tvComments = (TextView) convertView.findViewById(R.id.tvComments);
        TextView tvSubreddit = (TextView) convertView.findViewById(R.id.tvSubreddit);
        ImageView ivThumbnail = (ImageView) convertView.findViewById(R.id.ivThumbnail);

        tvUpvotes.setText("" + post.getUpvotes());
        tvTitle.setText(post.getTitle());
        tvDomain.setText(post.getDomain());
        tvComments.setText(post.getNumComments()+ " comments");
        tvSubreddit.setText(post.getSubreddit());

        String thumbnailUrl = post.getThumbnail();
        if(thumbnailUrl.length() < 1|| thumbnailUrl.equals("self")){
            ivThumbnail.setImageResource(R.drawable.reddit_alien);
        }else{
            Picasso.with(getContext()).load(thumbnailUrl).into(ivThumbnail);
        }

        return convertView;

    }
}
