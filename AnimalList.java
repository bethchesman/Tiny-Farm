import java.io.Serializable;
import java.util.Iterator;


public class AnimalList implements Iterable<Animal>, Serializable{
	
	private AnimalNode head, tail;
	private int size =0;
	
	public AnimalList() {
		head = tail = null;
	}
	
	public AnimalList(Animal animals) {
		for (int i = 0; i < size; i++)
			add(i, animals);	
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if(size == 0) return true;
		else return false;
	}
	
	public void addFirst(Animal animal) {		
		AnimalNode newNode = new AnimalNode(animal); 
		if (tail == null) 			
			head = tail = newNode; 	
		else {
			newNode.next = head; 
			head = newNode; 		
		}
		size++;
	}
	
	public void addLast(Animal animal) {		
		AnimalNode newNode = new AnimalNode(animal); 
		if (tail == null) 			
			head = tail = newNode; 
		else {
			tail.next = newNode; 	
			tail = tail.next; 		
		}
		size++;
	}
	
	public void add(Animal animal) { 
		addLast(animal);			 
	}
	
	public void add(int index, Animal animal){
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		else if (index == 0)	addFirst(animal);
		else if (index == size) addLast(animal);
		else {
			AnimalNode newNode = new AnimalNode(animal);
			AnimalNode current = head; 		
			for (int i = 1; i < index; i++)
				current = current.next; 	
			newNode.next = current.next; 	
			current.next = newNode; 	
			size++;
		}
	}
	
	public Animal removeFirst() {		
		if (size == 0)
			return null;
		else {
			AnimalNode temp = head; 	
			head = head.next;
			size--;
			if (head == null) 		
				tail = null;
			return temp.element; 	
		}
	}
	public Animal removeLast() {			
		if (size == 0)
			return null;
		else if (size == 1) {
	        AnimalNode temp = head;
	        head = tail = null;
	        size = 0;
	        return temp.element;
		} else {
			AnimalNode temp = tail; 	
			AnimalNode current = head; 	
			for (int i = 0; i < size - 2; i++)
				current = current.next;
			tail = current;
			tail.next = null; 			
			size--;
			return temp.element; 		
		}
	}
	public Animal remove(int index) {	
		if (index < 0 || index >= size)
			return null;
		else if (index == 0)
			return removeFirst();
		else if (index == size - 1)
			return removeLast();
		else {
			AnimalNode prev = head;
			for (int i = 1; i < index; i++)
				prev = prev.next;
			AnimalNode current = prev.next;
			prev.next = current.next;
			size--;
			return current.element;
		}
	}
	public boolean remove(Animal animals) {
		if (indexOf(animals) >= 0) {	
			remove(indexOf(animals));	
			return true;		
		} else
			return false;
	}
	
	public Animal getFirst() {
		if (size == 0)
			return null;
		else
			return head.element;
	}
	public Animal getLast() {
		if (size == 0)
			return null;
		else
			return tail.element;
	}
	
	public Animal get(int index) {	
		if (index < 0 || index >= size)
			return null;
		else if (index == 0)
			return getFirst();
		else if (index == size - 1)
			return getLast();
		else {
			AnimalNode current = head; 		
			for (int i = 0; i < index; i++)	
				current = current.next; 	
			return current.element;
		}
	}
	
	public Animal set(int index, Animal animals) {	
		if (index < 0 || index > size - 1)
			return null;
		AnimalNode current = head;
		for (int i = 0; i < index; i++)
			current = current.next;
		Animal temp = current.element;
		current.element = animals;
		return temp;
	}
	
	public String toString() {
		String finalString = "";
		Iterator<Animal> myIterator = iterator();
		while(myIterator.hasNext()) {
			Animal animal = (Animal) myIterator.next();
			finalString += animal.getName() + " : " + animal.isAlive() + " at ( ";
		}
		return finalString;
	}
	
	public int indexOf(Animal animals) {
		AnimalNode current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(animals))
				return i;
			current = current.next;
		}
		return -1;
	}
	
	public Iterator<Animal> iterator() {
		return null;
	}
	
	public AnimalList getHungryAnimals() {
		AnimalList hungry = new AnimalList();
		for (int i = 0; i < size; i++) {
			if(animals.getEnergy() < 50) {
				hungry.add(animals);
			}
		}
		if(hungry.size() > 0) {
		    return hungry;
		}
		else return null;
	}
	
	public AnimalList getStarvingAnimals() {
		AnimalList starving = new AnimalList();
		for (int i = 0; i < size; i++) {
			if(animal.getEnergy() < 17) {
				starving.add(animal);
			}
		}
		if(starving.size() > 0) {
		    return starving;
		}
		else return null;
	}
	
	public AnimalList getAnimalsInBarn() {
		
		return null;
	}
	
	public double getRequiredFood() {
		double foodRequired = 0;
		for(int x = 0; x < size; x++) {
			foodRequired = foodRequired + Math.min(animal.getMealAmount(), (100-animal.getEnergy()));
		}
		
		return foodRequired;
	}

	private static class AnimalNode {	
		Animal element;
		AnimalNode next;

		public AnimalNode(Animal animals) {
			element = animals;
		}
	}
	

}
