package com.example.caveatEmptor;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.caveatEmptor.itemType.AuctionType;
import com.example.caveatEmptor.model.Bid;
import com.example.caveatEmptor.model.Item;
import com.example.caveatEmptor.service.BidService;
import com.example.caveatEmptor.service.ItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceTest {

	@Autowired
	private ItemService itemService;

	@Autowired
	private BidService bidService;

	@Test
	public void saveTest() {
		addItem();
		assertEquals(1, itemService.findAll().size());
		assertEquals(2, bidService.findAll().size());
		bidService.deleteAll();
		itemService.deleteAll();
	}

	@Test
	public void deleteTest() {
		addItem();
		assertEquals(1, itemService.findAll().size());
		assertEquals(2, bidService.findAll().size());
		itemService.deleteAll();
		assertEquals(0, itemService.findAll().size());
		assertEquals(0, bidService.findAll().size());
	}

	private void addItem() {
		Bid bid = new Bid(new BigDecimal(234.1));
		Bid bid2 = new Bid(new BigDecimal(567.1));
		Item item = new Item("Fan", "Working in sound condition");
		item.setAuctionType(AuctionType.FIXED_PRICE);
		item.getBids().add(bid);
		item.getBids().add(bid2);
		bid.setItem(item);
		bid2.setItem(item);
		itemService.save(item);
	}

	@After
	@Test
	public void clearDatabase() {
		bidService.deleteAll();
		itemService.deleteAll();
	}
}
