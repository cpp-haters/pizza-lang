package org.panda_lang.framework.structure;

/**
 * Specific type of scope which contains own memory, independence, etc.
 */
public interface Wrapper extends Container {

    /**
     * Creates new instance of the current wrapper for individual values for fields, etc.
     *
     * @return instance of the current wrapper
     */
    WrapperInstance createInstance();

    /**
     * @return wrapper name
     */
    String getName();

    /**
     * @return the order counted from the main wrapper
     */
    int getID();

}