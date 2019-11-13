package com.grupo.iamsa.android.Models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Example",strict = false)
public class Example {

    @Element(name = "ejemplo")
    private String text = "Algo";

    @Attribute
    private int index = 12;
}
