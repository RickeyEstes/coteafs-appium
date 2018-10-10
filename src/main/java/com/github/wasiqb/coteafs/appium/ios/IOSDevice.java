/**
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.appium.ios;

import static io.appium.java_client.ios.IOSStartScreenRecordingOptions.startScreenRecordingOptions;
import static io.appium.java_client.ios.IOSStopScreenRecordingOptions.stopScreenRecordingOptions;

import com.github.wasiqb.coteafs.appium.device.Device;
import com.github.wasiqb.coteafs.appium.service.AppiumServer;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;

/**
 * @author wasiq.bhamla
 * @since 13-Apr-2017 5:33:35 PM
 */
public class IOSDevice extends Device <IOSDriver <MobileElement>, IOSTouchAction> {
	/**
	 * @author wasiq.bhamla
	 * @since 13-Apr-2017 9:12:09 PM
	 * @param server
	 * @param name
	 */
	public IOSDevice (final AppiumServer server, final String name) {
		super (server, name);
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.Device#startRecord()
	 */
	@Override
	protected void startRecord () {
		if (this.setting.getPlayback ()
			.isRecord ()) {
			this.driver.startRecordingScreen (startScreenRecordingOptions ());
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.appium.device.Device#stopRecord()
	 */
	@Override
	protected void stopRecord () {
		if (this.setting.getPlayback ()
			.isRecord ()) {
			final String content = this.driver.stopRecordingScreen (stopScreenRecordingOptions ());
			saveRecording (content);
		}
	}
}