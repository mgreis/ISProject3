package is.project3.subscriptions;

import org.mule.api.MuleEvent;
import org.mule.extension.validation.api.ValidationResult;
import org.mule.extension.validation.api.Validator;

public class PriceRangeValidator implements Validator {

	@Override
	public ValidationResult validate(MuleEvent event) {
		Object payload = event.getMessage().getPayload();
		if (payload instanceof Subscription) {
			Subscription data = (Subscription) payload;
			if (data.getMinimumPrice() <= data.getMaximumPrice()) {
				return new ValidResult();
			} else {
				return new InvalidResult();
			}
		}
		throw new UnsupportedOperationException("payload must have type "
				+ Subscription.class.getName());
	}

	class ValidResult implements ValidationResult {

		@Override
		public boolean isError() {
			return false;
		}

		@Override
		public String getMessage() {
			return "Price range is valid.";
		}
	};

	class InvalidResult implements ValidationResult {

		@Override
		public boolean isError() {
			return true;
		}

		@Override
		public String getMessage() {
			return "Minimum price must be lower or equal to maximum price.";
		}
	}

}
