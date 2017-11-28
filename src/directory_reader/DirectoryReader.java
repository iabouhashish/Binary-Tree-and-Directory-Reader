package directory_reader;

import java.io.File;
import javax.swing.JFileChooser;

/**
 * Select, read, and print the contents of a directory.
 */
public class DirectoryReader {

	/**
	 * Select a directory, then print the full path to the directory and its
	 * contents, one per line. Prefix the contents with a hyphen and a space.
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fileChooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			File[] list = file.listFiles();
			
			System.out.println(file);
			
			for (int i = 0; i < list.length; i++) {
			      if (list[i].isFile()) {
			        System.out.println("- " + list[i].getName());
			      } else if (list[i].isDirectory()) {
			        System.out.println("- " + list[i].getName() + "/");
			      }
			    }
		}
	}
}
