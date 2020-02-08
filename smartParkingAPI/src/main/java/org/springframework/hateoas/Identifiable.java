
package org.springframework.hateoas;

import java.io.Serializable;
public interface Identifiable<ID extends Serializable> {
	ID getId();
}
