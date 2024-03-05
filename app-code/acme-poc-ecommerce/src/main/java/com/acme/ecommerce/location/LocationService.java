/*----------------------------------------------------------------------------*/
/* Source File:   LOCATIONSERVICE.JAVA                                        */
/* Copyright (c), 2024 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Mar.1/2024  COQ  File created.
 -----------------------------------------------------------------------------*/
package com.acme.ecommerce.location;

import com.acme.ecommerce.rs.Location;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * @author COQ - Carlos Adolfo Ortiz Q.
 */
@Component
public class LocationService {

    public List<Store> getNearbyStores(Location location) {
        return List.of(new Store("Seattle"), new Store("Issaquah"));
    }
}
