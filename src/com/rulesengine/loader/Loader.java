package com.rulesengine.loader;

import java.io.File;
import java.util.ArrayList;

import com.rulesengine.model.Rule;

public interface Loader {
	
	public ArrayList<Rule> load(File file) throws Exception;

}
