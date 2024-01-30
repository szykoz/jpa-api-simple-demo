/* ******************************************************************
 * Copyright (c) 2003-2024 by PROSTEP AG                          *
 * All rights reserved                                               *
 *                                                                   *
 *   ___  ___  ___  _  _  ___  __   _    _                           *
 *  | _ || _ || __|| \| || _ || _ \| \  / |                          *
 *  ||_||| /_|| _/ |  ' || /_|||_ ||  ''  |                          *
 *  |___||_|  |___||_|\_||_|  |__ /|_|\/|_|                          *
 *                                                                   *
 * This software is furnished under a license and may be used and    *
 * copied only in accordance with the terms of such license and      *
 * with the inclusion of the above copyright notice. This            *
 * software or any other copies thereof may not be provided or       *
 * otherwise made available to a third person. No title to and       *
 * ownership of the software is hereby transferred.                  *
 *                                                                   *
 * The information in this software is subject to change without     *
 * notice and should not be construed as a commitment by ProSTEP     *
 *                                                                   *
 * The PROSTEP AG assumes only responsibility defined in a contract  *
 * and no responsibility for the use or reliability of its software  *
 * on equipment which is not supplied by the PROSTEP AG.             *
 *                                                                   *
 *********************************************************************/

//
// Author          : koziol
// Start           : 2024
//
package com.szymix.customer;

import com.szymix.customer.models.Customer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getInt("age")
        );
    }
}
