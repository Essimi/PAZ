package kr.or.ddit.vo;

import java.util.List;

public class KanbanVO<T> {
	
	//node 자체를 가리키기 때문에 타입을 <T>로 준다
	T data;
	
	//다음노드를 가리키는 변수 
	public KanbanVO<T> next;
	
	 private Integer kb_col_no;
	 private Integer kb_col_priv_no;
	 
	
	public KanbanVO(T data){
		this.data = data;
		this.next = null;
	}
	

}
