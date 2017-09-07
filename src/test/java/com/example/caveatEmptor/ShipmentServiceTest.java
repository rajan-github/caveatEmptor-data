package com.example.caveatEmptor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.caveatEmptor.itemType.AuctionType;
import com.example.caveatEmptor.model.Item;
import com.example.caveatEmptor.model.advanced.Shipment;
import com.example.caveatEmptor.service.ItemService;
import com.example.caveatEmptor.service.ShipmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShipmentServiceTest {

	@Autowired
	private ShipmentService shipmentService;

	@Autowired
	private ItemService itemService;

	@Test
	public void saveTest() {
		Shipment shipment = new Shipment();
		shipmentService.save(shipment);

		Item item = new Item("Fan", "Working in sound condition");
		item.setAuctionType(AuctionType.FIXED_PRICE);
		itemService.save(item);

		Shipment auctionShipment = new Shipment(item);
		shipmentService.save(auctionShipment);
	}

}
