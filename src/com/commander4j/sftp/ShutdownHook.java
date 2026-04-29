package com.commander4j.sftp;

import org.apache.logging.log4j.LogManager;

import com.commander4j.util.JWait;


public class ShutdownHook extends Thread
{

	@Override
	public void run()
	{
		
		JWait wait = new JWait();
		Transfer.sftpput.requestStop();
		Transfer.sftpput.interrupt();

		while (Transfer.sftpput.isAlive())
		{

			wait.oneSec();
		}
	
		LogManager.shutdown();
	}

}
