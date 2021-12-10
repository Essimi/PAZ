package kr.or.ddit.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rometools.rome.feed.rss.Category;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Item;

@Controller
public class RssFeedController {
	
	@RequestMapping("/testRssFeed.do")
	@ResponseBody
	public Channel testRssFeed() {
		
		return makeFeed();
		
	}

	private Channel makeFeed() {
		
		//기본 FEED 정보
        Channel channel = new Channel();
        channel.setFeedType("rss_2.0");
        channel.setTitle("PAZ");
        channel.setDescription("PAZ 를 이용하여 협업을 진행해보세요!");
        channel.setLink("http://127.0.0.1:8080");
        channel.setGenerator("InputTypeText");
        channel.setPubDate(new Date());
			
        List<Item> itemList = new ArrayList<Item>();
		
        //발행할 새로운 소식
        String array[][] = {
            {"InputTypeText", "https://주소/newStory1","제목1","내 카테고리","설명1을 입력합니다."},
            {"InputTypeText", "https://주소/newStory2","제목2","내 카테고리","설명2을 입력합니다."}
        };
		
        //소식을 item에 추가 합니다.
        for(String data [] : array) {
            Item item = new Item();
            item.setAuthor(data[0]);
            item.setLink(data[1]);
            item.setTitle(data[2]);
            Category category = new Category();
            category.setValue(data[3]);
            item.setCategories(Collections.singletonList(category));
				
            Description descr = new Description();
            descr.setValue(data[4]);
            item.setDescription(descr);
            item.setPubDate(new Date());
            itemList.add(item);
            channel.setItems(itemList);			
        }

        return channel;
    }
}