/*----------------------------------------------------------------------------*/
/* Source File:   INVENTORYSERVICE.JAVA                                       */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.inventory;

import com.acme.ecommerce.location.LocationService;
import com.acme.ecommerce.product.domain.Product;
import com.acme.ecommerce.rs.Location;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Component
public class InventoryService {

    private LocationService locationService;

    @Autowired
    public InventoryService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void readInInventory() throws IOException {
        try (Reader in = new InputStreamReader(getClass().getResourceAsStream("/product_inventory.csv"))) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader("productId", "location", "quantity")
                .withFirstRecordAsHeader()
                .parse(in);

            for (CSVRecord record : records) {
                String productId = record.get("productId");
                String location = record.get("location");
                int quantity = Integer.valueOf(record.get("quantity"));
                System.out.println(productId + "\t" + location + "\t" + quantity);
            }
        }
    }

    public boolean hasInventoryOnline(Product product, int quantity) {
        return false;
    }

    public boolean hasInventoryInNearbyStores(Product product, int quantity, Location currentLocation) {
        return true;
    }
}
