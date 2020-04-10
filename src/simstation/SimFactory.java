/**
 * Edit History
 * 4/10 Katrina Slivkoff created getView method
 */
package simstation;

import mvc.*;

public interface SimFactory extends AppFactory{
	public View getView(Model model);

}
