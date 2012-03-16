
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraper
{

	String get_path_from_page(String pageLink) throws IOException
	{

		// create the url string for the pdf
		String pdfString = null;

		// Make a connection to the website and get the entire html document
		Document doc = Jsoup.connect(pageLink).get();

		// parse out specifically meta content that contains name =
		// citation_pdf_url
		Elements metaContent = doc.select("meta[name=citation_pdf_url]");

		// Grab the first element of the Elements
		Element firstElement = metaContent.first();

		// assign the pdf string
		pdfString = firstElement.attr("content");

		return pdfString;

	}

	String get_abstract_path(int volume, int issue, int pages)
	{
		String abstractPath = "http://rsfs.royalsocietypublishing.org/content/";
		abstractPath += volume + "/" + issue + "/" + pages + ".abstract";

		return abstractPath;

	}

	String get_pdf_path(int volume, int issue, int pages)
	{
		String pdfPath = null;
		
		//create the abstractUrl using the get_abstract_path method
		String abstractPath = get_abstract_path(volume, issue, pages);
		
		//
		try
		{
			pdfPath=get_path_from_page(abstractPath);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Error in retrieving the abstract url: "+ abstractPath);
			e.printStackTrace();
		}

		return pdfPath;
	}

	public static void main(String[] args) throws IOException
	{
		
		
		WebScraper scraper = new WebScraper();
		
	//	System.out.println(scraper.get_pdf_path(2,1,13));
		System.out.println(scraper.get_pdf_path(2,2,150));
	}

}
