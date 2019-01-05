package com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.expanRcAdapter.bean;

import java.util.List;

/**

 */

public class RecyclerViewData<T,S>{

    private GroupItem groupItem;

    public RecyclerViewData(T groupData, List<S> childDatas, boolean isExpand) {
        this.groupItem = new GroupItem(groupData,childDatas,isExpand);
    }

    public RecyclerViewData(T groupData, List<S> childDatas) {
        this.groupItem = new GroupItem(groupData,childDatas,false);
    }

    public GroupItem getGroupItem() {
        return groupItem;
    }

    public boolean getIsExpan(){
        return groupItem.isExpand();
    }

    public void  setIsExpan(boolean isExpan){
        groupItem.setExpand(isExpan);
    }

    public void setGroupItem(GroupItem groupItem) {
        this.groupItem = groupItem;
    }

    public T getGroupData(){
       return (T)groupItem.getGroupData();
    }

    public void removeChild(int position){
        if(null == groupItem || !groupItem.hasChilds()){
            return;
        }
        groupItem.getChildDatas().remove(position);
    }

    public S getChild(int childPosition){
        return (S)groupItem.getChildDatas().get(childPosition);
    }

}
