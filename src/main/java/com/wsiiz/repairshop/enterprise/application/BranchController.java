package com.wsiiz.repairshop.enterprise.application;

import com.wsiiz.repairshop.enterprise.domain.branch.Branch;
import com.wsiiz.repairshop.enterprise.domain.branch.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/branches")
public class BranchController {

    private final BranchService branchService;

    @GetMapping
    public ResponseEntity<List<Branch>> getAllBranches(
            @RequestParam(value = "branchId", required = false) Long branchId,
            @RequestParam(value = "localityBranch", required = false) String localityBranch) {
        if (Objects.nonNull(localityBranch)) {
            return ResponseEntity.ok(branchService.getAllBranchByLocalityBranch(localityBranch));
        } else if (Objects.nonNull(branchId)) {
            return ResponseEntity.ok(branchService.getAllByBranchId(branchId));
        }
        return ResponseEntity.ok(branchService.getAllBranch());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Branch> getBranchById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @PostMapping
    public ResponseEntity<Branch> createBranch(@RequestBody @Valid Branch branch) {
        return ResponseEntity.ok(branchService.createBranch(branch));
    }

    @DeleteMapping("/{id}")
    public void removeBranch(@PathVariable("id") Long id) {
        branchService.removeBranchById(id);
    }
}