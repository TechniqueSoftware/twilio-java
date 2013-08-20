package com.twilio.sdk.resource.list;

import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.ListResource;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageList.
 *
 * For more information see <a href="http://www.twilio.com/docs/api/rest/message">http://www.twilio.com/docs/api/rest/message</a>
 */
public class MessageList extends ListResource<Message> implements MessageFactory {

	/**
	 * Instantiates a new Message list.
	 *
	 * @param client the client
	 */
	public MessageList(TwilioRestClient client) {
		super(client);
	}

	/**
	 * Instantiates a new Message list.
	 *
	 * @param client the client
	 * @param filters the filters
	 */
	public MessageList(TwilioRestClient client, Map<String, String> filters) {
		super(client, filters);
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.Resource#getResourceLocation()
	 */
	@Override
	protected String getResourceLocation() {
		return "/" + TwilioRestClient.DEFAULT_VERSION + "/Accounts/"
				+ this.getRequestAccountSid() + "/Messages.json";
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.ListResource#makeNew(com.twilio.sdk.TwilioRestClient, java.util.Map)
	 */
	@Override
	protected Message makeNew(TwilioRestClient client, Map<String, Object> params) {
		return new Message(client, params);
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.ListResource#getListKey()
	 */
	@Override
	protected String getListKey() {
		return "messages";
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.factory.MessageFactory#create(java.util.Map)
	 */
	public Message create(Map<String, String> params) throws TwilioRestException {
		TwilioRestResponse response = this.getClient().safeRequest(
				this.getResourceLocation(), "POST", params);
		return makeNew(this.getClient(), response.toMap());
	}

}
