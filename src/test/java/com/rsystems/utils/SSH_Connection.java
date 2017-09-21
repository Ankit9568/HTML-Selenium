package com.rsystems.utils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SSH_Connection {

	private String host = null;
	private String user = null;
	private String password = null;

	public void rebootSTBAndSetup(String stbIP, String userName, String password) throws InterruptedException {

		this.host = stbIP;
		this.user = userName;
		this.password = password;

		startQTDriver("cd /etc/params; ls -ltr; remote_reboot");
		Thread.sleep(120000);
		System.out.println("HEllo");
		while (true) {
			System.out.println(pingMachine());
			if (pingMachine()) {
				
				String command1 = "cd /etc/params/webdriver_release_20Sep;killall QtTestBrowser;./run.sh";
				startQTDriver(command1);
				break;
			} else {
				continue;
			}
		}
		startQTDriver("ps | grep QtTestBrowser");
	}

	boolean pingMachine() {
		boolean reachble = false;
		System.out.println("Ping Poller Starts...");

		try {
			InetAddress inet = InetAddress.getByName(host);
			System.out.println("Sending Ping Request to " + host);

			boolean status = inet.isReachable(5000); // Timeout = 5000 milli
														// seconds

			if (status) {
				System.out.println("Status : Host is reachable");
				reachble = true;
			} else {
				System.out.println("Status : Host is not reachable");
				reachble = false;
			}
		} catch (UnknownHostException e) {
			System.err.println("Host does not exists");
			reachble = false;
		} catch (IOException e) {
			System.err.println("Error in reaching the Host");
			reachble = false;
		}
		return reachble;
	}

	void startQTDriver(String command) {

		try {

			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, 22);
			jsch.addIdentity(System.getProperty("user.dir") + File.separator + "openssh.pem", password);
			session.setPassword(password);
			session.setConfig(config);
			session.connect();
			System.out.println("Connected");

			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);

			channel.connect();

			Thread.sleep(3000);

			channel.disconnect();
			session.disconnect();
			System.out.println("DONE");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
