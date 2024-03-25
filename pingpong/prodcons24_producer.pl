%====================================================================================
% prodcons24_producer description   
%====================================================================================
request( distance, distance(D) ).
reply( distanceack, ack(D) ).  %%for distance
%====================================================================================
context(ctxping, "localhost",  "TCP", "8014").
context(ctxpong, "127.0.0.1",  "TCP", "8015").
 qactor( pong, ctxpong, "external").
  qactor( ping, ctxping, "it.unibo.ping.Ping").
 static(ping).
