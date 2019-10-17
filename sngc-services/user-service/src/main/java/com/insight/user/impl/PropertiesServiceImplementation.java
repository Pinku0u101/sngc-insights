package com.insight.user.impl;

import java.util.Map;
import java.util.UUID;

import com.insight.user.contract.PropertiesServiceInterface;
import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.ODatabaseType;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.record.OElement;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesServiceImplementation implements PropertiesServiceInterface
{
    @Override
    public Map<String, String> createProperties( Map<String, String> properties )
    {
        OrientDB orientDB = new OrientDB("plocal:/Users/prakashp/sngc-insights/sngc-insights/orientdb-3.0.22/databases/", OrientDBConfig.defaultConfig());

        orientDB.createIfNotExists("Insights", ODatabaseType.PLOCAL );

        ODatabaseSession db = orientDB.open("Insights", "admin", "admin");

        for( String key : properties.keySet() )
        {
            if ( db.getClass( key ) == null  )
            {
                db.createVertexClass( key );
                db.newVertex( key );
            }

            try {
                OElement vertex = db.newInstance( key );
                vertex.setProperty("Id", UUID.randomUUID().toString() );
                vertex.setProperty("Name", properties.get( key ) );

                vertex.save();
                vertex.clear();
            }
            catch ( Exception e)
            {

            }
            finally {


            }

        }

        db.close();
        orientDB.close();

        return properties;
    }
}
