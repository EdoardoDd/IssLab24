package main.towardsactors24;

import java.io.FileWriter;
import java.io.IOException;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.utils.CommUtils;
import unibo.naiveactors24.ActorBasic24;
import unibo.naiveactors24.ActorContext24;

public class ObsLogger extends ActorBasic24{
	private FileWriter myWriter  ;
	protected String pfx          = "        ";


	public ObsLogger(String name, ActorContext24 ctx) {
		super(name, ctx);
		
		try {
			myWriter = new FileWriter("obsloggerLog.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//	Iscrizione al produttore e al consumatore
 		IApplMessage msg1 = CommUtils.buildDispatch( name, "update", "msg" , "prod1");
 		IApplMessage msg2 = CommUtils.buildDispatch( name, "update", "msg" , "consumer");

		CommUtils.outcyan( pfx  + name + " | iscrizione " + msg1 );
		forward( msg1 );
		CommUtils.outcyan( pfx  + name + " | iscrizione " + msg2 );
		forward( msg2 );
		
		//
		activateAndStart();
	}

	@Override
	protected void elabMsg(IApplMessage msg) throws Exception {
		CommUtils.outyellow( name + " | elabMsg " + msg + " " + Thread.currentThread().getName() ) ; 
		if( msg.msgId().equals("update")) handleMsg(msg);
		
	}

	public void handleMsg( IApplMessage msg ) {       
        CommUtils.outcyan(name + "  | logger " + msg.msgContent() + " sent by " + msg.msgSender() + " " + Thread.currentThread().getName());		
        writeLog(msg.toString()); 
	}
	
	/*
	 * Scrittura di informazione sul log file:
	 * un primo modo per rendere il componente OSSERVABILE
	 */
	protected void writeLog(String s) {
		try {
			 myWriter.append(s+"\n");
			 myWriter.flush();
		} catch (IOException e) {
 			e.printStackTrace();
		}
	}

}
