package kr.or.ddit.news.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.news.service.NewsService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NewsVO;
import kr.or.ddit.vo.ProjectVO;

@Controller
public class NewsDeleteController {


      @Inject
      private NewsService service;
   
      @ResponseBody
      @RequestMapping(value = "project/{pCode}/news/newsDelete.do", method=RequestMethod.GET)
      public Map<String, Object> getCalendarRemoveForm(
            NewsVO news,
            Model model,
            @PathVariable("pCode") String pCode,
            @AuthenticationPrincipal(expression="authMember") MemberVO authMember
            ){
         news.setpCode(pCode);
         news.setMemId(authMember.getMemId());
         
         ServiceResult result = service.removeNews(news);
         
         model.addAttribute("news", news);
         
         String message = null;
         
         Map<String, Object> res = new HashMap<>();
         res.put("result", result);
         
         if(result == ServiceResult.OK) {
         message = "성공하였습니다.";
         res.put("redirect", "/project/" + pCode + "/news/newsList.do");   
         }else {
         message = "댓글이 있는 게시물은 삭제할 수 없습니다.";
         res.put("redirect", "/project/" + pCode + "/news/newsList.do");   

         }
         res.put("message", message);
         return res;
         
      
      }
      
      @RequestMapping(value = "project/{pCode}/news/newsDelete.do", method=RequestMethod.POST)
      public String Access(
            NewsVO news,
            Model model,
            @PathVariable("pCode") String pCode,
            @AuthenticationPrincipal(expression="authMember") MemberVO authMember
            
            ) {
         news.setpCode(pCode);
         news.setMemId(authMember.getMemId());
         
         ServiceResult result = service.removeNews(news);
         
         model.addAttribute("news", news);
         return "news/newsList";
         
      }
   }