package com.example.datastructures;

public class Array {

	public int[] myArray;
	
	public static int size = 10;
	
	public void printArray() {
		for (int i = 0; i < size; i++) {
			System.out.println("| "+i+" | "+myArray[i]+" |");
		}
	}
	
	public Array() {
		System.out.println("\nFilling the integer array with random numbers between 21-30");
		
		myArray = new int[size];
		
		for (int i = 0; i < size; i++) {
			myArray[i] = (int)(Math.random()*10+20);
		}
		printArray();
	}
	
	public int[] searchInt(int value) {
		// have some length bigger than our original array
		int[] indexes = new int[20];
		
		// return -1 value if no match
		indexes[0] = -1;
		
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (myArray[i] == value) {
				indexes[j] = i;
				j++;
			}
		}
		return indexes;
	}
	
	// linear search since duplicate values might happen
	public String search(int value) {
		System.out.println("\nSearching this: "+value);
		
		String result = "Found here: ";
		boolean found = false;
		
		for (int i = 0; i < size; i++) {
			if (myArray[i] == value) {
				found = true;
				result += i+" "; 
			}
		}
		
		if(!found) {
			result = "Nothing found :(";
		}
		
		return result;
	}
	
	public String insert(int value) {
		
		System.out.println("\nInserting this value: "+value);
		
		if(value<20 || value>30) {
			return value + " is not in accepted range, insert fail!";
		}
		
		size++;
		
		int[] biggerArray = new int[size];
		
		for (int i = 0; i < size-1; i++) {
			biggerArray[i] = myArray[i];
		}
		
		biggerArray[size-1] = value;
		
		myArray = biggerArray;
		
		printArray();
		
		return "Value added";
		
	}
	
	public String removeIndex(int index) {
		
		System.out.println("\nRemoving this index: "+index);
		
		if(index>=size || index<0) {
			return index+" is out of range!";
		}
		
		for (int i = index; i < size-1; i++) {
			myArray[i] = myArray[i+1];
		}
		size--;
		
		printArray();
		
		return "value removed";
	}
	
	public String replace(int value, int newValue) {
		System.out.println("\nRemoving this value: "+value);
		
		// this value can exist more than once
		// first find the indexes
		int[] result = searchInt(value);
		if(result[0] == -1){
			return "No value found";
		}
		
		// index 0 can have this value, need to have a switch to cover that
		boolean index0passed = false;
		
		for (int i = 0; i < result.length; i++) {
			if(index0passed && result[i] == 0) {
				break;
			}
			index0passed = true;
			System.out.println("\nRemoving this index: "+result[i]);
		    myArray[result[i]] = newValue;
		}
		
		printArray();
		
		return "value replaced";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		// initialize array
		Array newArray = new Array();
		
		// search a value, like 22
		System.out.println(newArray.search(22));
		
		// try to add a wrong value
		System.out.println(newArray.insert(32));
		
		// try to add a correct value
	    System.out.println(newArray.insert(23));
	    
	    // remove index 11
	    System.out.println(newArray.removeIndex(11));
	    
	    // remove index 3
	    System.out.println(newArray.removeIndex(3));
	    
	    // replace 23 with 30
	    System.out.println(newArray.replace(23,30));
		
	}

}
