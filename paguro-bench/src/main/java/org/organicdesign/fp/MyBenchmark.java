package org.organicdesign.fp;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.organicdesign.fp.collections.BaseList;
import org.organicdesign.fp.collections.ImList;
import org.organicdesign.fp.collections.PersistentVector;
import org.organicdesign.fp.collections.RrbTree;
import org.organicdesign.fp.collections.RrbTree.ImRrbt;
import org.organicdesign.fp.collections.RrbTree.MutableRrbt;

import java.util.ArrayList;
import java.util.List;

// Instructions: http://openjdk.java.net/projects/code-tools/jmh/

public class MyBenchmark {

    public static List<Integer> buildList2(int maxIdx) {
        List<Integer> empty = new ArrayList<>();
        for (int i = 0; i < maxIdx; i++) {
            empty.add(i);
        }
        return empty;
    }

    @SuppressWarnings("unchecked")
    public static <T extends BaseList<Integer>> T buildList(T empty, int maxIdx) {
        for (int i = 0; i < maxIdx; i++) {
            empty = (T) empty.append(i);
        }
        return empty;
    }

    public static ImRrbt<Integer> insertAtZeroRrb(int maxIdx) {
        ImRrbt<Integer> empty = RrbTree.empty();
        for (int i = maxIdx; i >= 0; i--) {
            empty = empty.insert(0, i);
        }
        return empty;
    }

    public static MutableRrbt<Integer> insertAtZeroRrbMut(int maxIdx) {
        MutableRrbt<Integer> empty = RrbTree.emptyMutable();
        for (int i = maxIdx; i >= 0; i--) {
            empty = empty.insert(0, i);
        }
        return empty;
    }

    public static List<Integer> insertAtZeroList(int maxIdx) {
        ArrayList<Integer> empty = new ArrayList<>();
        for (int i = maxIdx; i >= 0; i--) {
            empty.add(0, i);
        }
        return empty;
    }

    public static Integer iterateList(Iterable<Integer> is) {
        Integer last = null;
        for (Integer item : is) {
            last = item;
        }
        return last;
    }

    public static Integer getEach(List<Integer> is) {
        Integer last = null;
        int size = is.size();
        for (int i = size - 1; i >= 0; i--) {
            last = is.get(i);
        }
        return last;
    }

    @State(Scope.Thread) public static class Rrb1 {
        public ImList<Integer> rrb = buildList(RrbTree.empty(), 1);
    }
    @State(Scope.Thread) public static class Rrb10 {
        public ImList<Integer> rrb = buildList(RrbTree.empty(), 10);
    }
    @State(Scope.Thread) public static class Rrb100 {
        public ImList<Integer> rrb = buildList(RrbTree.empty(), 100);
    }
    @State(Scope.Thread) public static class Rrb1000 {
        public ImList<Integer> rrb = buildList(RrbTree.empty(), 1000);
    }
    @State(Scope.Thread) public static class Rrb10000 {
        public ImList<Integer> rrb = buildList(RrbTree.empty(), 10000);
    }
    @State(Scope.Thread) public static class Rrb100000 {
        public ImList<Integer> rrb = buildList(RrbTree.empty(), 100000);
    }
    @State(Scope.Thread) public static class Rrb1000000 {
        public ImList<Integer> rrb = buildList(RrbTree.empty(), 1000000);
    }
    @State(Scope.Thread) public static class Rrb10000000 {
        public ImList<Integer> rrb = buildList(RrbTree.empty(), 10000000);
    }

    @State(Scope.Thread) public static class Vec1 {
        public ImList<Integer> vec = buildList(PersistentVector.empty(), 1);
    }
    @State(Scope.Thread) public static class Vec10 {
        public ImList<Integer> vec = buildList(PersistentVector.empty(), 10);
    }
    @State(Scope.Thread) public static class Vec100 {
        public ImList<Integer> vec = buildList(PersistentVector.empty(), 100);
    }
    @State(Scope.Thread) public static class Vec1000 {
        public ImList<Integer> vec = buildList(PersistentVector.empty(), 1000);
    }
    @State(Scope.Thread) public static class Vec10000 {
        public ImList<Integer> vec = buildList(PersistentVector.empty(), 10000);
    }
    @State(Scope.Thread) public static class Vec100000 {
        public ImList<Integer> vec = buildList(PersistentVector.empty(), 100000);
    }
    @State(Scope.Thread) public static class Vec1000000 {
        public ImList<Integer> vec = buildList(PersistentVector.empty(), 1000000);
    }
    @State(Scope.Thread) public static class Vec10000000 {
        public ImList<Integer> vec = buildList(PersistentVector.empty(), 10000000);
    }

    @State(Scope.Thread) public static class List1 { public List<Integer> list = buildList2(1); }
    @State(Scope.Thread) public static class List10 { public List<Integer> list = buildList2(10); }
    @State(Scope.Thread) public static class List100 { public List<Integer> list = buildList2(100); }
    @State(Scope.Thread) public static class List1000 { public List<Integer> list = buildList2(1000); }
    @State(Scope.Thread) public static class List10000 { public List<Integer> list = buildList2(10000); }
    @State(Scope.Thread) public static class List100000 { public List<Integer> list = buildList2(100000); }
    @State(Scope.Thread) public static class List1000000 { public List<Integer> list = buildList2(1000000); }
    @State(Scope.Thread) public static class List10000000 { public List<Integer> list = buildList2(10000000); }


    @Benchmark public void BuildRrb1() { buildList(RrbTree.empty(), 1); }
    @Benchmark public void BuildRrb10() { buildList(RrbTree.empty(), 10); }
    @Benchmark public void BuildRrb100() { buildList(RrbTree.empty(), 100); }
    @Benchmark public void BuildRrb1000() { buildList(RrbTree.empty(), 1000); }
    @Benchmark public void BuildRrb10000() { buildList(RrbTree.empty(), 10000); }
    @Benchmark public void BuildRrb100000() { buildList(RrbTree.empty(), 100000); }
    @Benchmark public void BuildRrb1000000() { buildList(RrbTree.empty(), 1000000); }
    @Benchmark public void BuildRrb10000000() { buildList(RrbTree.empty(), 10000000); }

    @Benchmark public void BuildRrbMut1() { buildList(RrbTree.emptyMutable(), 1); }
    @Benchmark public void BuildRrbMut10() { buildList(RrbTree.emptyMutable(), 10); }
    @Benchmark public void BuildRrbMut100() { buildList(RrbTree.emptyMutable(), 100); }
    @Benchmark public void BuildRrbMut1000() { buildList(RrbTree.emptyMutable(), 1000); }
    @Benchmark public void BuildRrbMut10000() { buildList(RrbTree.emptyMutable(), 10000); }
    @Benchmark public void BuildRrbMut100000() { buildList(RrbTree.emptyMutable(), 100000); }
    @Benchmark public void BuildRrbMut1000000() { buildList(RrbTree.emptyMutable(), 1000000); }
    @Benchmark public void BuildRrbMut10000000() { buildList(RrbTree.emptyMutable(), 10000000); }

    @Benchmark public void BuildVec1() { buildList(PersistentVector.empty(), 1); }
    @Benchmark public void BuildVec10() { buildList(PersistentVector.empty(), 10); }
    @Benchmark public void BuildVec100() { buildList(PersistentVector.empty(), 100); }
    @Benchmark public void BuildVec1000() { buildList(PersistentVector.empty(), 1000); }
    @Benchmark public void BuildVec10000() { buildList(PersistentVector.empty(), 10000); }
    @Benchmark public void BuildVec100000() { buildList(PersistentVector.empty(), 100000); }
    @Benchmark public void BuildVec1000000() { buildList(PersistentVector.empty(), 1000000); }
    @Benchmark public void BuildVec10000000() { buildList(PersistentVector.empty(), 10000000); }

    @Benchmark public void BuildVecMut1() { buildList(PersistentVector.emptyMutable(), 1); }
    @Benchmark public void BuildVecMut10() { buildList(PersistentVector.emptyMutable(), 10); }
    @Benchmark public void BuildVecMut100() { buildList(PersistentVector.emptyMutable(), 100); }
    @Benchmark public void BuildVecMut1000() { buildList(PersistentVector.emptyMutable(), 1000); }
    @Benchmark public void BuildVecMut10000() { buildList(PersistentVector.emptyMutable(), 10000); }
    @Benchmark public void BuildVecMut100000() { buildList(PersistentVector.emptyMutable(), 100000); }
    @Benchmark public void BuildVecMut1000000() { buildList(PersistentVector.emptyMutable(), 1000000); }
    @Benchmark public void BuildVecMut10000000() { buildList(PersistentVector.emptyMutable(), 10000000); }

    @Benchmark public void BuildList1() { buildList2(1); }
    @Benchmark public void BuildList10() { buildList2(10); }
    @Benchmark public void BuildList100() { buildList2(100); }
    @Benchmark public void BuildList1000() { buildList2(1000); }
    @Benchmark public void BuildList10000() { buildList2(10000); }
    @Benchmark public void BuildList100000() { buildList2(100000); }
    @Benchmark public void BuildList1000000() { buildList2(1000000); }
    @Benchmark public void BuildList10000000() { buildList2(10000000); }

    @Benchmark public void InsertZeroList1() { insertAtZeroList(1); }
    @Benchmark public void InsertZeroList10() { insertAtZeroList(10); }
    @Benchmark public void InsertZeroList100() { insertAtZeroList(100); }
    @Benchmark public void InsertZeroList1000() { insertAtZeroList(1000); }
    @Benchmark public void InsertZeroList10000() { insertAtZeroList(10000); }
    @Benchmark public void InsertZeroList100000() { insertAtZeroList(100000); }
    // These take more than a second.
//    @Benchmark public void InsertZeroList1000000() { insertAtZeroList(1000000); }
//    @Benchmark public void InsertZeroList10000000() { insertAtZeroList(10000000); }

    @Benchmark public void InsertZeroRrb1() { insertAtZeroRrb(1); }
    @Benchmark public void InsertZeroRrb10() { insertAtZeroRrb(10); }
    @Benchmark public void InsertZeroRrb100() { insertAtZeroRrb(100); }
    @Benchmark public void InsertZeroRrb1000() { insertAtZeroRrb(1000); }
    @Benchmark public void InsertZeroRrb10000() { insertAtZeroRrb(10000); }
    @Benchmark public void InsertZeroRrb100000() { insertAtZeroRrb(100000); }
    @Benchmark public void InsertZeroRrb1000000() { insertAtZeroRrb(1000000); }
    // Takes more than a second.
//    @Benchmark public void InsertZeroRrb10000000() { insertAtZeroRrb(10000000); }

    @Benchmark public void InsertZeroRrbMut1() { insertAtZeroRrbMut(1); }
    @Benchmark public void InsertZeroRrbMut10() { insertAtZeroRrbMut(10); }
    @Benchmark public void InsertZeroRrbMut100() { insertAtZeroRrbMut(100); }
    @Benchmark public void InsertZeroRrbMut1000() { insertAtZeroRrbMut(1000); }
    @Benchmark public void InsertZeroRrbMut10000() { insertAtZeroRrbMut(10000); }
    @Benchmark public void InsertZeroRrbMut100000() { insertAtZeroRrbMut(100000); }
    @Benchmark public void InsertZeroRrbMut1000000() { insertAtZeroRrbMut(1000000); }
    @Benchmark public void InsertZeroRrbMut10000000() { insertAtZeroRrbMut(10000000); }

    @Benchmark public void IterateRrb1(Rrb1 rrb) { iterateList(rrb.rrb); }
    @Benchmark public void IterateRrb10(Rrb10 rrb) { iterateList(rrb.rrb); }
    @Benchmark public void IterateRrb100(Rrb100 rrb) { iterateList(rrb.rrb); }
    @Benchmark public void IterateRrb1000(Rrb1000 rrb) { iterateList(rrb.rrb); }
    @Benchmark public void IterateRrb10000(Rrb10000 rrb) { iterateList(rrb.rrb); }
    @Benchmark public void IterateRrb100000(Rrb100000 rrb) { iterateList(rrb.rrb); }
    @Benchmark public void IterateRrb1000000(Rrb1000000 rrb) { iterateList(rrb.rrb); }
    @Benchmark public void IterateRrb10000000(Rrb10000000 rrb) { iterateList(rrb.rrb); }

    @Benchmark public void IterateVec1(Vec1 vec) { iterateList(vec.vec); }
    @Benchmark public void IterateVec10(Vec10 vec) { iterateList(vec.vec); }
    @Benchmark public void IterateVec100(Vec100 vec) { iterateList(vec.vec); }
    @Benchmark public void IterateVec1000(Vec1000 vec) { iterateList(vec.vec); }
    @Benchmark public void IterateVec10000(Vec10000 vec) { iterateList(vec.vec); }
    @Benchmark public void IterateVec100000(Vec100000 vec) { iterateList(vec.vec); }
    @Benchmark public void IterateVec1000000(Vec1000000 vec) { iterateList(vec.vec); }
    @Benchmark public void IterateVec10000000(Vec10000000 vec) { iterateList(vec.vec); }

    @Benchmark public void IterateList1(List1 list) { iterateList(list.list); }
    @Benchmark public void IterateList10(List10 list) { iterateList(list.list); }
    @Benchmark public void IterateList100(List100 list) { iterateList(list.list); }
    @Benchmark public void IterateList1000(List1000 list) { iterateList(list.list); }
    @Benchmark public void IterateList10000(List10000 list) { iterateList(list.list); }
    @Benchmark public void IterateList100000(List100000 list) { iterateList(list.list); }
    @Benchmark public void IterateList1000000(List1000000 list) { iterateList(list.list); }
    @Benchmark public void IterateList10000000(List10000000 list) { iterateList(list.list); }

    @Benchmark public void GetEachRrb1(Rrb1 rrb) { getEach(rrb.rrb); }
    @Benchmark public void GetEachRrb10(Rrb10 rrb) { getEach(rrb.rrb); }
    @Benchmark public void GetEachRrb100(Rrb100 rrb) { getEach(rrb.rrb); }
    @Benchmark public void GetEachRrb1000(Rrb1000 rrb) { getEach(rrb.rrb); }
    @Benchmark public void GetEachRrb10000(Rrb10000 rrb) { getEach(rrb.rrb); }
    @Benchmark public void GetEachRrb100000(Rrb100000 rrb) { getEach(rrb.rrb); }
    @Benchmark public void GetEachRrb1000000(Rrb1000000 rrb) { getEach(rrb.rrb); }
    @Benchmark public void GetEachRrb10000000(Rrb10000000 rrb) { getEach(rrb.rrb); }

    @Benchmark public void GetEachVec1(Vec1 vec) { getEach(vec.vec); }
    @Benchmark public void GetEachVec10(Vec10 vec) { getEach(vec.vec); }
    @Benchmark public void GetEachVec100(Vec100 vec) { getEach(vec.vec); }
    @Benchmark public void GetEachVec1000(Vec1000 vec) { getEach(vec.vec); }
    @Benchmark public void GetEachVec10000(Vec10000 vec) { getEach(vec.vec); }
    @Benchmark public void GetEachVec100000(Vec100000 vec) { getEach(vec.vec); }
    @Benchmark public void GetEachVec1000000(Vec1000000 vec) { getEach(vec.vec); }
    @Benchmark public void GetEachVec10000000(Vec10000000 vec) { getEach(vec.vec); }

    @Benchmark public void GetEachList1(List1 list) { getEach(list.list); }
    @Benchmark public void GetEachList10(List10 list) { getEach(list.list); }
    @Benchmark public void GetEachList100(List100 list) { getEach(list.list); }
    @Benchmark public void GetEachList1000(List1000 list) { getEach(list.list); }
    @Benchmark public void GetEachList10000(List10000 list) { getEach(list.list); }
    @Benchmark public void GetEachList100000(List100000 list) { getEach(list.list); }
    @Benchmark public void GetEachList1000000(List1000000 list) { getEach(list.list); }
    @Benchmark public void GetEachList10000000(List10000000 list) { getEach(list.list); }
}
