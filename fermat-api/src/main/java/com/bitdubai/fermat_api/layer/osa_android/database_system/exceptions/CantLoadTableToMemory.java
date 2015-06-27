package com.bitdubai.fermat_api.layer.osa_android.database_system.exceptions;

/**
 * Created by toshiba on 24/03/2015.
 */
public class CantLoadTableToMemory extends DatabaseSystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4735647755255875137L;

	public static final String DEFAULT_MESSAGE = "CAN'T LOAD TABLE TO MEMORY";

	public CantLoadTableToMemory(final String message, final Exception cause, final String context, final String possibleReason) {
		super(message, cause, context, possibleReason);
	}

	public CantLoadTableToMemory(final String message, final Exception cause) {
		this(message, cause, "", "");
	}

	public CantLoadTableToMemory(final String message) {
		this(message, null);
	}

	public CantLoadTableToMemory(final Exception exception) {
		this(exception.getMessage());
		setStackTrace(exception.getStackTrace());
	}

	public CantLoadTableToMemory() {
		this(DEFAULT_MESSAGE);
	}
}
