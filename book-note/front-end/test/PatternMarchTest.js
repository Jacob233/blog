class PatternMarchTest{

    test=()=>{
    var s = 'aaaaacccccbbbbb';
    var a = s.split('');
    a.sort();
    s = a.join('');
    var pattern = /(\w)\1*/g;
    var ans = s.match(pattern);
    ans.sort(function(a, b) {
        return a.length < b.length;
    });
    console.log(ans[0][0] + ': ' + ans[0].length);
    return "test";
    }

    render(){
        return <a>{this.test()}</a>
    }

}
export default PatternMarchTest;