function delFruit(fid){
    if(confirm('是否确认删除？')){
        window.location.href='delEmp?fid='+fid;
    }
}