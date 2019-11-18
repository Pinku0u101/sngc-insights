package com.sngc.insight.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sngc.insight.Repository.InsightsRepository;

public class InsightsHandler
{
    private static final String INSIGHTS = "insights";
    private InsightsRepository insightsRepository;

    public Map<String, Map<String, List<String>>> getInsights( Map<String, String> UserIds )
    {
        insightsRepository = new InsightsRepository();

        Map<String, Map<String, List<String>>> userProps = insightsRepository.getEdges( UserIds );

        this.createInsights( userProps );

        return userProps;
    }

    private void createInsights( Map<String, Map<String, List<String>>> userProps )
    {
        Map<String, List<String>> user1Properties = userProps.get( "user1" );
        Map<String, List<String>> user2Properties = userProps.get( "user0" );

        Map<String, List<String>> insights = new HashMap<>();



        String user0 = user2Properties.get( "userDetails" ).get( 0 );
        String user1 = user1Properties.get( "userDetails" ).get( 0 );

        for( String key : user1Properties.keySet() )
        {
            if( user2Properties.get( key ) != null )
            {
                if( key.equals( "interested" ) )
                {
                    for( String value : user1Properties.get( key ) )
                    {
                        if( user2Properties.get( key ) != null )
                        {
                            insights.put( key, Arrays.asList( "Both users are interested in " + value ) );
                        }
                    }
                }

                if( key.equals( "notInterested" ) )
                {
                    List<String> notInterested = new ArrayList<>();
                    for( String value : user1Properties.get( key ) )
                    {
                        if( user2Properties.get( key ) != null )
                        {
                            notInterested.add( user0 + "is not interested in " + value );
                        }
                        else
                        {
                            if( user2Properties.get( "interested" ).contains( value ) ) notInterested.add( "you are interested in "+ value );
                        }
                        insights.put( key, notInterested );
                    }
                }

                if( key.equals( "likeToEat" ) )
                {
                    List<String> likesToEat = new ArrayList<>();
                    List<String> unHealthyFoods = new ArrayList<>(Arrays.asList(  "pizza", "burger", "fries"  ));


                    if( user2Properties.get( key ).contains( unHealthyFoods ) )
                        likesToEat.add( "avoid eating unhealthy foods. This will make you lazy. reduce your concentration an eventually become less active" );

                    if( user2Properties.get( key ).contains( unHealthyFoods ) && !user1Properties.get( key ).contains( unHealthyFoods ) )
                        likesToEat.add( user0 + "does not eat unhealthy foods !!! Would be better to improve it from your side as well" );

                    if( !user2Properties.get( key ).contains( unHealthyFoods ) )
                        likesToEat.add( "you have good eating habits !!! Whooo  hoooooo" );

                    insights.put( key, likesToEat );
                }

                if( key.equals( "wantToBecome" ) )
                {
                    List<String> wantToBecome = new ArrayList<>();

                    if( user2Properties.get( key ).get( 0 ).equals( "Scientist" ) )
                    {
                        wantToBecome.add( "think deep, different perspective" );
                    }
                }
            }
        }

        int size1 = user1Properties.get( "interested" ).size();
        int size2 = user2Properties.get( "interested" ).size();

        List<String> user0List = new ArrayList<>();
        List<String> user1List = new ArrayList<>();

        for ( int i=0; i<size1 ; i++)
        {
            user1List.add( String.valueOf( (int) ( Math.random() * ( 20 ) + 1 ) ) );
        }

        for ( int i=0; i<size2 ; i++)
        {
            user0List.add( String.valueOf( (int) (Math.random() * ( 20 ) + 1 ) ) ) ;
        }

        userProps.get( "user0" ).put( "day", user0List );
        userProps.get( "user1" ).put( "day", user1List );

        userProps.put( INSIGHTS, insights );
    }
}
