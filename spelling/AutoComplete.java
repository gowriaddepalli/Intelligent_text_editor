/**
 * 
 */
package spelling;

import java.util.List;

/**
 * @author gowri
 *
 */
public interface AutoComplete {
	public List<String> predictCompletions(String prefix, int numCompletions);
}
