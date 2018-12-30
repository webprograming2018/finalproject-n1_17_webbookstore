package com.fsoft.minhla1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.fsoft.minhla1.entities.Book;


public class Cart implements Serializable {
	/**
	 * 
	 */
	private int quantity;
	private HashMap<Book, Integer> items;
	private double totalAmount;

	public Cart() {
		items = new HashMap<Book, Integer>();
	}

	public int getQuantity() {
		return this.quantity;
	}

	public HashMap<Book, Integer> getItems() {
		return this.items;
	}

	public void addItem(Book book) {
		if (items.containsKey(book)) {
			items.replace(book, items.get(book) + 1);
		} else {
			items.put(book, 1);
		}
		this.quantity += 1;
		track(book);
	}

	public void removeItem(Book book) {
		if (items.containsKey(book)) {
			Integer itemQtt = items.get(book);
			if (itemQtt > 1) {
				items.replace(book, itemQtt - 1);
			} else {
				items.remove(book);
				System.out.println("Deleted");
			}
		}

		this.quantity=this.quantity<=0?0:this.quantity- 1;
		track(book);
	}

	public double getTotalAmount() {
		Set<Book> bookSet = items.keySet();
		totalAmount = 0;
		for (Book book : bookSet) {
			Integer number = items.get(book);
			if (number != null)
				totalAmount += book.getPrice() * number;
		}
		return this.totalAmount;
	}

	private void track(Book book) {
		System.out.println("Action performed to " + book.getName());
		System.out.println("Now, quantity/amount is:" + getQuantity() + "/" + getTotalAmount());
		System.out.println("Total: " + items.size());
	}
}