package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.foundation.domain.AbstractFactory;
import org.springframework.stereotype.Component;

@Component
public class BranchFactory implements AbstractFactory<Branch> {
    public BranchFactory() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Branch create() {
        return new Branch();
    }
}
