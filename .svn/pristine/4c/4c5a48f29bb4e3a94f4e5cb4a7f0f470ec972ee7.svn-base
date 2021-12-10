package kr.or.ddit.vo;

public class SLinkedList<T> implements KanbanListVO<T> {

	private KanbanVO<T> head;
	private KanbanVO<T> tail;
	
	//요소 개수 
	private int size;
	
	//생성자 
	
	public SLinkedList() {
		
		//리스트의 가장 첫 노드를 가르키는 변수
		this.head = null;
		
		//리스트의 가장 마지막 노드를 가르키는 변수
		this.tail = null;
		
		//리스트에 있는 요소의 개수 (=연결된 노드의 개수)
		this.size = 0;
	}
	
	private KanbanVO<T> search(int index) {
		
		// 범위 밖(잘못된 위치)일 경우 예외 던지기 
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		KanbanVO<T> x = head; // head부터 시작
 
		for (int i = 0; i < index; i++) {
			x = x.next; // x노드의 다음 노드를 x에 저장한다.
		}
		return x;
	}
	
	public void addFirst(T value) {
		 
		KanbanVO<T> newNode = new KanbanVO<T>(value); // 새 노드 생성
		newNode.next = head; // 새 노드의 다음 노드로 head 노드를 연결
		head = newNode; // head가 가리키는 노드를 새 노드로 변경
		size++;
 
		/**
		 * 다음에 가리킬 노드가 없는 경우(=데이터가 새 노드밖에 없는 경우) 
		 * 데이터가 한 개(새 노드)밖에 없으므로 새 노드는 처음 시작노드이자
		 * 마지막 노드다. 즉 tail = head 다.
		 */
		if (head.next == null) {
			tail = head;
		}
	}
	
	public void addLast(T value) {
		KanbanVO<T> newNode = new KanbanVO<T>(value); // 새 노드 생성
 
		if (size == 0) { // 처음 넣는 노드일 경우 addFisrt로 추가
			addFirst(value);
			return;
		}
 
		/**
		 * 마지막 노드(tail)의 다음 노드(next)가 새 노드를 가리키도록 하고
		 * tail이 가리키는 노드를 새 노드로 바꿔준다.
		 */
		tail.next = newNode;
		tail = newNode;
		size++;
	}
			
	
	@Override
	public boolean add(T value) {
		addLast(value);
		return true;
	}

	@Override
	public void add(int index, T value) {
		// 잘못된 인덱스를 참조할 경우 예외 발생
				if (index > size || index < 0) {
					throw new IndexOutOfBoundsException();
				}
				// 추가하려는 index가 가장 앞에 추가하려는 경우 addFirst 호출 
				if (index == 0) {
					addFirst(value);
					return;
				}
				// 추가하려는 index가 마지막 위치일 경우 addLast 호출
				if (index == size) {
					addLast(value);
					return;
				}
				
				// 추가하려는 위치의 이전 노드 
				KanbanVO<T> prev_Node = search(index - 1);
				
				// 추가하려는 위치의 노드
				KanbanVO<T> next_Node = prev_Node.next;
		 
				// 추가하려는 노드
				KanbanVO<T> newNode = new KanbanVO<T>(value);	
				
				/**
				 * 이전 노드가 가리키는 노드를 끊은 뒤
				 * 새 노드로 변경해준다. 
				 * 또한 새 노드가 가리키는 노드는 next_Node로
				 * 설정해준다. 
				 */
				prev_Node.next = null;
				prev_Node.next = newNode;
				newNode.next = next_Node;
				size++;
		
	}

	@Override
	public T get(int index) {
		return search(index).data;
	}

	@Override
	public void set(int index, T value) {
		KanbanVO<T> replaceNode = search(index);
		replaceNode.data = null;
		replaceNode.data = value;
		
	}

	@Override
	public boolean contains(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object value) {
	int index = 0;
		
		for (KanbanVO<T> x = head; x != null; x = x.next) {
			if (value.equals(x.data)) {
				return index;
			}
			index++;
		}
		// 찾고자 하는 요소를 찾지 못했을 경우 -1 반환
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	//getter setter

	public KanbanVO<T> getHead() {
		return head;
	}

	public void setHead(KanbanVO<T> head) {
		this.head = head;
	}

	public KanbanVO<T> getTail() {
		return tail;
	}

	public void setTail(KanbanVO<T> tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
