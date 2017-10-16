package com.mr.gof.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class Editor {

    private Document document = new Document();
    private List<Object> documentHistory = new ArrayList<Object>();
    private int docuemntIndex;

    public void updateContent(String content){
        document.setContent(content);
        documentHistory.add( document.save() );
        docuemntIndex = documentHistory.size() - 1;
    }

    public boolean undo(){
        if (docuemntIndex ==0) return false;
        document.restore(documentHistory.get(--docuemntIndex));
        return true;
    }

    public boolean redo(){
        if ( docuemntIndex == documentHistory.size() - 1 ) return false;
        document.restore(documentHistory.get(++docuemntIndex));
        return true;
    }

    public void displayContent(){
        System.out.println(document.getContent());
    }

    public static void main(String[] args ){
        Editor editor = new Editor();
        editor.updateContent("step 1");
        editor.displayContent();
        editor.updateContent("step 2");
        editor.displayContent();
        editor.updateContent("step 3");
        editor.displayContent();
        editor.updateContent("step 4");
        editor.displayContent();
        if ( editor.undo() ) {
            editor.displayContent();
        }
        if ( editor.redo() ) {
            editor.displayContent();
        }
    }
}
