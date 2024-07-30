
interface Document{
    void save();
}

class WordDocument implements Document{
    @Override
    public void save(){
        System.out.println("Saving a word document");
    }
}
class PdfDocument implements Document{
    @Override
    public void save(){
        System.out.println("Saving a pdf document");
    }
}
class ExcelDocument implements Document{
    @Override
    public void save(){
        System.out.println("Saving a excel document");
    }
}
abstract class DocumentFactory{
    abstract Document createDocument();
}
class WordDocumentFactory extends DocumentFactory{

    Document createDocument() {
        System.out.println("Using factory method of Word Document");
        return new WordDocument();
    }
}
class PdfDocumentFactory extends DocumentFactory{
    @Override
    Document createDocument(){
        System.out.println("Using factory method of Pdf Document");
        return new PdfDocument();
    }
}
class ExcelDocumentFactory extends DocumentFactory{
    Document createDocument(){
        System.out.println("Using factory method of Excel Document");
        return new ExcelDocument();
    }
}

public class Main {
    public static Document getDocument(String doctype){

        if(doctype.trim().equalsIgnoreCase("word")){
            DocumentFactory docf=new WordDocumentFactory();
            Document doc=docf.createDocument();
            return doc;
        }
        else if(doctype.trim().equalsIgnoreCase("pdf")){
            DocumentFactory docf=new PdfDocumentFactory();
            Document doc=docf.createDocument();
            return doc;
        }
        else if(doctype.trim().equalsIgnoreCase("excel")){
            DocumentFactory docf=new ExcelDocumentFactory();
            Document doc=docf.createDocument();
            return doc;
        }
        return null;
    }
    public static void main(String[] args) {
        Document wdoc,pdoc,edoc;
        wdoc=getDocument(" word  ");
        pdoc=getDocument("Pdf");
        edoc=getDocument("Excel");
        //test case
        wdoc.save();
        pdoc.save();
        edoc.save();
    }
}