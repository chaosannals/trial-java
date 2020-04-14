package trial.search;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.cn.smart.*;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;

public class Engine {
    private Analyzer analyzer;
    private Directory directory;
    private IndexWriterConfig iwconfig;

    public Engine() throws IOException {
        analyzer = new SmartChineseAnalyzer();
        Path indexPath = Files.createTempDirectory("tempIndex");
        directory = FSDirectory.open(indexPath);
        iwconfig = new IndexWriterConfig(analyzer);
    }

    public void addDocument(List<Field> fields) throws IOException {
        try (IndexWriter iwriter = new IndexWriter(directory, iwconfig)) {
            Document doc = new Document();
            for (Field field : fields) {
                doc.add(field);
            }
            iwriter.addDocument(doc);
        }
    }

    public List<Document> search(String field, String text) throws IOException, ParseException {
        try (DirectoryReader dreader = DirectoryReader.open(directory)) {
            IndexSearcher isearcher = new IndexSearcher(dreader);
            QueryParser parser = new QueryParser(field, analyzer);
            Query query = parser.parse(text);
            ScoreDoc[] hits = isearcher.search(query, 10).scoreDocs;
            ArrayList<Document> result = new ArrayList<>();
            for (ScoreDoc h : hits) {
                result.add(isearcher.doc(h.doc));
            }
            return result;
        }
    }
}