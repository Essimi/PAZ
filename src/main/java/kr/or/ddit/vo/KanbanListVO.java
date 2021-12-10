package kr.or.ddit.vo;

public interface KanbanListVO<T> {
	
	//리스트에 요소를 추가한다
	boolean add(T value);
	
	//리스트에 요소를 특정 위치에 추가한다 
	
	void add(int index, T value);
	
	//리스트에 있는 특정 위치의 요소 반환
	
	T get(int index);
	
	//리스트에  특정 위치에 있는 요소를 새 요소로 대체
	
	void set(int index, T value);
	
	//리스트에 특정 요소가 리스트에 있는지 여부 확인
	boolean contains(Object value);
	
	//리스트에 특정 요소가 몇 번째 위치에 있는지 반환
	int indexOf(Object value);
	
	//리스트에 요소 개수를 반환
	int size();
	
	//리스트에 요소가 비어있는지 반환 
	boolean isEmpty();

}
