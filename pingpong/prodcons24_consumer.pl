%====================================================================================
% prodcons24_consumer description   
%====================================================================================
request( distance, distance(D) ).
reply( distanceack, ack(D) ).  %%for distance
%====================================================================================
context(ctxpong, "localhost",  "TCP", "8015").
 qactor( pong, ctxpong, "it.unibo.pong.Pong").
 static(pong).
