%====================================================================================
% prodcons24_producer description   
%====================================================================================
request( distance, distance(D) ).
reply( distanceack, ack(D) ).  %%for distance
dispatch( short, short(V) ).
%====================================================================================
context(ctxping, "localhost",  "TCP", "8014").
context(ctxpong, "localhost",  "TCP", "8015").
 qactor( pong, ctxpong, "external").
  qactor( ping, ctxping, "it.unibo.ping.Ping").
 static(ping).
