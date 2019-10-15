package com.sngc.insights;

import com.orientechnologies.orient.server.network.protocol.http.command.post.OServerCommandPostAuthToken;
import org.apache.tinkerpop.gremlin.orientdb.OrientGraph;
import org.apache.tinkerpop.gremlin.orientdb.OrientGraphFactory;
import org.jnosql.artemis.graph.GraphTemplate;


/**
 * Created by prakashp on 13/10/19.
 */
public class abcd
{
    @Inject
    private GraphTemplate graph;



    public static void main(String args[])
    {
        OrientGraphFactory ogf = new OrientGraphFactory(
                "plocal:/Users/prakashp/sngc-insights/orientdb-3.0.22/databases/demodb", "admin", "admin");
        OrientGraph og = ogf.getTx();

        GraphTemplate an ;

        






    }
}
