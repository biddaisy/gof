package com.mr.gof.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramanovich on 12/30/2016.
 */
public interface ParentNode extends Node {

    List<Node> getChildren();

    void addChild(Node childNode);

}
