const base = {
    get() {
        return {
            url : "http://localhost:8080/zhihuitushu/",
            name: "zhihuitushu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhihuitushu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: " 智慧图书管理系统"
        } 
    }
}
export default base
