%====================================================================================
% helloworld0 description   
%====================================================================================
dispatch( info, info(N) ). %Informazione inviata dal worker(prod)
request( req, req(N) ). %Richiesta inviata dal worker(prod)
%====================================================================================
context(ctxhello, "localhost",  "TCP", "8000").
 qactor( worker, ctxhello, "it.unibo.worker.Worker").
 static(worker).
  qactor( display, ctxhello, "it.unibo.display.Display").
 static(display).
