package db.exception;

/**
 * Enumerate type represents exceptions details using in database module like
 * code and more detailed description.
 * 
 * @author Mateusz Mucha
 *
 */
public enum ExceptionDescription {
	NONE("", ""), 
	HIBERNATE_SESSION_OPEN("0x001", "Problem with opening hibernate session."), 
	HIBERNATE_TRANSATION_FAIL("0x002", "Problem with commit operation."), 
	CLASS_FIELDS_SECURITY("1x010", "Violation of class security during reading class fields. Maybe fields are not possible to access? Check it!"), 
	CLASS_FIELDS_ACCESS("1x020", "Field of object is enforcing Java language access control and the underlying field is inaccessible."), 
	CLASS_FIELDS_ARGUMENT("1x030", "The specified object is not an instance of the class or interface declaring the underlying field. Possible problem with superclass.");

	private String exceptionCode, exceptionDescription;

	ExceptionDescription(String exceptionCode, String exceptionDescription) {
		this.exceptionCode = exceptionCode;
		this.exceptionDescription = exceptionDescription;
	}

	/**
	 * Method returns code of database exception.
	 * 
	 * @return the exceptionCode
	 */
	public String getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * Method returns more details of exception.
	 * 
	 * @return the exceptionDescription
	 */
	public String getExceptionDescription() {
		return exceptionDescription;
	}

	/**
	 * Method returns all details of exception.
	 * 
	 * @return full description
	 */
	public String fullDescription() {
		return new StringBuilder("ErrorCode: ")
				.append(getExceptionCode())
				.append(", Description: ")
				.append(getExceptionDescription())
				.toString();
	}
}