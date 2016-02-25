/*
 * 
 * 
 */


public class TimLinkedList<E> implements Cloneable, List<E>, Serializable{
	
	private class Node<T>{
		T data;
		Node<T> next;
		
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
		
		public Node(T data){
			this(data, null);
		}
	}
	
	int size;
	Node<E> head;
	
	public TimLinkedList(){
		size = 0;
		head = new Node<E>(null);
	}
	
	public boolean add(E data){
		try{
			Node<E> curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = new Node<E>(data);
			size++;
			return true;
		}catch(Exception E){
			return false;
		}
	}
	
	public void add(int i, E data){
		if (i < 0 || i >= size)
			return;
		Node<E> curr = head;
		Node<E> prev = null;
		i++;
		for(i = i; i != 0; i--){
			prev = curr;
			curr = curr.next;
		}
		prev.next = new Node<E>(data, curr);
		size++;
	}
	
	public boolean addAll(Collection<? extends E> datas){
			if(datas.size() == 0)
				return false;
			Object[] a = datas.toArray();
			Node<E> curr = head.next;
			for(int i = 0; i < a.length; i++){
				if (!contains(a[i]))
					return false;
			}
			return true;
	}
	
	public boolean addAll(int index, Collection<? extends E> datas){
			if(datas.isEmpty())
				return false;
			Iterator<? extends E> iter = datas.iterator();
			i++;
			Node curr = head;
			Node prev = null;
			for(i = i; i != 0; i--){
				prev = curr;
				curr = curr.next;
			}
			while(iter.hasNext()){
				Node newNode = new Node(iter.next(), curr);
				prev.next = newNode;
				curr = newNode;
				size++;
				return true;
			}
	}
	
	public void addFirst(E data){
		head.next = new Node(data, head.next);
		size++;
	}
	
	public void addLast(E data){
		Node curr = head;
		while(curr.next != null){
			curr = curr.next;
		}
		curr.next = new Node(data);
		size++;
	}
	
	public void clear(){
		head = new Node(null);
		size = 0;
	}
	
	public E clone(){
		try{
			return (TimLinkedList<E>)super.clone();
		}catch(CloneNotSupportedException e){
			//this should not happen
		}
	}
	
	public boolean contains(E data){
			if (size == 0)
				return false;
			Node curr = head;
			while( curr != null){
				if (curr.data.equals(data))
					return true;
				curr = curr.next;
			}
			return false;
	}
	
	public boolean containsAll(Collection<? extends E> collection){
		if(collection.isEmpty())
			return false;
		for (Iterator<? extends E> iter = collection.iterator(); iter.hasNext();){
			if (!contains(iter.next()))
				return false;
		}
		return true;
	}
	
	public boolean equals(Object input){
		if (input.getClass().getSimpleName().equals(this.getClass().getSimpleName())){
			TimLinkedList<E> that = (TimLinkedList<E>)input;
				Node inputCurr = that.head;
				Node curr = this.head;
				if (that.size != this.size)
					return false;
				while(inputCurr != null && curr != null){
					if (!inputCurr.data.equals(curr.data))
						return false;
				}
				return true;
		}
		return false;
	}
	
}

