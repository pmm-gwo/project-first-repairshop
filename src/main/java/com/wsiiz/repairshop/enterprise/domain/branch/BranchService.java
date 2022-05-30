package com.wsiiz.repairshop.enterprise.domain.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;

    public List<Branch> getAllByBranchId(Long branchId) {
        if (branchId == null) {
            return branchRepository.findAll();
        } else {
            return branchRepository.findAllByParentBranch_Id(branchId);
        }
    }

    public Branch getBranchById(Long id) {
        return branchRepository.findById(id).orElseThrow(() -> new RuntimeException("Branch not found for Id:" + id));

    }

    public List<Branch> getAllBranchByLocalityBranch(String localityBranch) {
        return branchRepository.findAllByBranchAddress_LocalityBranch(localityBranch);

    }

    public List<Branch> getAllBranch() {
        return branchRepository.findAll();
    }

    public Branch createBranch(Branch branch) {
        if (Objects.nonNull(branch.getParentBranch())) {
            Branch parentBranch = getBranchById(branch.getParentBranch().getId());
            branch.setParentBranch(parentBranch);
        }
        return branchRepository.save(branch);
    }

    public void removeBranchById(Long id) {

        branchRepository.deleteById(id);
    }
}
