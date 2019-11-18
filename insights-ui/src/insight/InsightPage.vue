<template>
    <div class="sngc">
        <h2 class="titlebar" >Insights</h2>
        <div class="tabClass">
            <div class="tabHeading">
                <button class="liClass" v-for="(tab, index) in tabs" @click="currentTab = index"> {{ tab }} </button>                
            </div> <br/><br/>

            <div class="tabContent">

            <div v-show="currentTab === 0" > 

            <table>
                    <tr>
                        <th>Name</th>
                        <th>Occupation</th>
                        <th>College</th>
                        <th>Education</th>
                    </tr>

                    <tr>
                    <td v-for="user in userDetails1">{{ user }}</td>
                    </tr>
                    <tr>
                    <td v-for="user1 in userDetails2">{{ user1 }}</td>
                    </tr>
                    <tr>
                    <td colspan="4"> test ran at {{ new Date().toLocaleString() }} </td>
                    </tr>
                    <tr>
                    <td colspan="4"> test ran by {{ userName }} </td>
                    </tr>
                </table>
                
             </div>


            <div v-show="currentTab === 1" > 

            <div>
            <apexchart type=bar width=700 :options="chartOptionsDay" :series="seriesDay" />

            <apexchart type=line width=700 :options="chartOptionsWeek" :series="seriesStudy" />

            <apexchart type=area width=700 :options="chartOptionsWeek" :series="seriesEntertainment" />
            </div>

            <div>
            <apexchart type=donut width='100%' :options="chartOptionsDonut1" :series="seriesDonutUser1" />
            <apexchart type=pie width='100%' :options="chartOptionsDonut2" :series="seriesDonutUser2" />
            </div>


            </div>

            
            <div v-show="currentTab === 2" > 
            
            <apexchart type=line width=700 :options="chartOptionsWeek" :series="seriesStudy" />

            <apexchart type=area width=700 :options="chartOptionsWeek" :series="seriesEntertainment" />

            <apexchart type=bar width=500 height=380 :options="chartOptionsWeek" :series="seriesRelaxation" />

             </div>


            <div v-show="currentTab === 3" > General Interests </div>

            <div v-show="currentTab === 4" > Insights </div>
            </div>

        </div>



    </div>
</template>

<script>

    export default {
        name : 'tabs',
        data(){
            return{
                currentTab: 0,
                tabs: ['Summary', 'A Day', 'A Week', 'Profession', 'Insights'],

                userDetails1: [],
                userDetails2: [],
                userName: '',
                userName2: '',

                options: {
                    chart: {
                    id: 'vuechart-example'
                    },
                    xaxis: {
                    categories: [1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998]
                    }
                } ,
               
                series: [{
                    name: 'frrr-1',
                    data: [30, 40, 45, 50, 49, 60, 70, 91]
                }],

            //DAILY ACTIVITIES --- START

                seriesDay: [{
                    name: '',
                    data: [1, 2, 4, 2, 1, 2, 7, 1]
                },
                {
                    name: '',
                    data: [1, 2, 1, 4, 1, 1, 12, 4]
                }],

                seriesDonutUser1: [],

                seriesDonutUser2: [],

            //DAILY ACTIVITIES --- END


            //WEEKLY ACTIVITIES --- START

                seriesStudy:[
                    //READING
                    {
                    name: '',
                    data:[]
                    },
                    {
                        name: '',
                        type: 'area',
                        data:[]
                    },
                //WRITING

                    {
                        name: '',
                        type: 'line',
                        data:[]
                    },
                    {
                        name: '',
                        type: 'line',
                        data:[]
                    },

                    //STUDY

                    {
                        name: '',
                        type: 'line',
                        data:[]
                    },
                    {
                        name: '',
                        type: 'area',
                        data:[]
                    }
                ],

                //Games and tv
                seriesEntertainment:[
                    //Games
                    {
                    name: '',
                    data:[]
                    },
                    {
                        name: '',
                        data:[]
                    },
                //Watching Tv - Entertainment programs

                    {
                        name: '',
                        data:[]
                    },
                    {
                        name: '',
                        data:[]
                    },

                    //STUDY

                    {
                        name: '',
                        data:[]
                    },
                    {
                        name: '',
                        data:[]
                    }
                ],

                seriesRelaxation:[
                    //Games
                    {
                    name: '',
                    data:[]
                    },
                    {
                        name: '',
                        type: 'bar',
                        data:[]
                    },
                //Watching Tv - Entertainment programs

                    {
                        name: '',
                        type: 'line',
                        data:[]
                    },
                    {
                        name: '',
                        type: 'area',
                        data:[]
                    }
                ],
            //WEEKLY ACTIVITIES --- END


                chartOptionsDonut1: {
                    labels: [],
                    dataLabels: {
            dropShadow: {
              blur: 3,
              opacity: 0.8
            }
          },
                        responsive: [{
                        breakpoint: 480,
                        options: {
                        chart: {
                            width: 500
                        },
                        legend: {
                            position: 'bottom'
                        }
                        }
          }]
        },

        chartOptionsDonut2: {
                    labels: [],
                    dataLabels: {
            dropShadow: {
              blur: 3,
              opacity: 0.8
            }
          },
                        responsive: [{
                        breakpoint: 480,
                        options: {
                        chart: {
                            width: 500
                        },
                        legend: {
                            position: 'bottom'
                        }
                        }
          }]
        },


        chartOptionsWeek:{   
          chart: {
                height: 350,
                zoom: {
                    enabled: false
                }
            },
            dataLabels: {
                enabled: true
            },
            stroke: {
                curve: 'smooth'
            },
            title: {
                text: 'Time Spending by Week',
                align: 'left'
            },
            grid: {
                row: {
                    colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
                    opacity: 0.5
                },
            },
            xaxis: {
                categories: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            }
        },

        chartOptionsDay:{   
          chart: {
                zoom: {
                    enabled: false
                }
            },
            dataLabels: {
                enabled: false
            },
            stroke: {
                curve: 'smooth'
            },
            title: {
                text: 'Time Spending by in a Day',
                align: 'left'
            },
            grid: {
                row: {
                    colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
                    opacity: 0.5
                },
            },
            xaxis: {
                categories: [],
            }
        }
            }
        },
        mounted:function(){
        this.method1() //method1 will execute at pageload
        },
        methods:{ 
            method1:function(){

                this.seriesStudy[0].name = 'Reading ' + localStorage.getItem('userName')
                this.seriesStudy[1].name = 'Reading ' + localStorage.getItem('userName2')
                this.seriesStudy[2].name = 'Writing ' + localStorage.getItem('userName')
                this.seriesStudy[3].name = 'Writing ' + localStorage.getItem('userName2')
                this.seriesStudy[4].name = 'Study ' + localStorage.getItem('userName')
                this.seriesStudy[5].name = 'Study ' + localStorage.getItem('userName2')

                this.seriesEntertainment[0].name = 'Computer Games ' + localStorage.getItem('userName')
                this.seriesEntertainment[1].name = 'Computer Games ' + localStorage.getItem('userName2')
                this.seriesEntertainment[2].name = 'tv ' + localStorage.getItem('userName')
                this.seriesEntertainment[3].name = 'tv ' + localStorage.getItem('userName2')
                this.seriesEntertainment[4].name = 'Out Door Games ' + localStorage.getItem('userName')
                this.seriesEntertainment[5].name = 'Out Door Games ' + localStorage.getItem('userName2')

                this.seriesRelaxation[0].name = 'Sleep ' + localStorage.getItem('userName')
                this.seriesRelaxation[1].name = 'Sleep ' + localStorage.getItem('userName2')
                this.seriesRelaxation[2].name = 'Travel ' + localStorage.getItem('userName')
                this.seriesRelaxation[3].name = 'Travel ' + localStorage.getItem('userName2')

                this.seriesDay[0].name = localStorage.getItem('userName');
                this.seriesDay[0].name = localStorage.getItem('userName2');
                
                var results =  localStorage.getItem('interested1').replace("[","").replace("]","").replace(/(")/g, '')
                var aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.chartOptionsDonut1.labels.push( aaa[i] );
                }

                var results =  localStorage.getItem('interested1').replace("[","").replace("]","").replace(/(")/g, '')
                var aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.chartOptionsDay.xaxis.categories.push( aaa[i] );
                }

                results =  localStorage.getItem('interested2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.chartOptionsDonut2.labels.push( aaa[i] );
                }

                var results =  localStorage.getItem('day1').replace("[","").replace("]","").replace(/(")/g, '')
                var aaa = results.split(",");
                for(var i = 0;i< aaa.length;i++)
                {
                    this.seriesDonutUser1.push( Math.floor(Math.random() * (70 - 1 + 1)) + 1);
                }

                var results =  localStorage.getItem('day2').replace("[","").replace("]","").replace(/(")/g, '')
                var aaa = results.split(",");
                for(var i = 0;i<aaa.length ;i++)
                {
                    this.seriesDonutUser2.push( Math.floor(Math.random() * (70 - 1 + 1)) + 1 );
                }

                results =  localStorage.getItem('reading1').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesStudy[0].data.push( aaa[i]);
                }

                results =  localStorage.getItem('reading2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesStudy[1].data.push( aaa[i]);
                }

                results =  localStorage.getItem('writing1').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesStudy[2].data.push( aaa[i]);
                }

                results =  localStorage.getItem('writing2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesStudy[3].data.push( aaa[i]);
                }

                results =  localStorage.getItem('study1').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesStudy[4].data.push( aaa[i]);
                }

                results =  localStorage.getItem('study2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesStudy[5].data.push( aaa[i]);
                }

                results =  localStorage.getItem('computerGames1').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesEntertainment[0].data.push( aaa[i]);
                }

                results =  localStorage.getItem('computerGames2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesEntertainment[1].data.push( aaa[i]);
                }

                results =  localStorage.getItem('tv1').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesEntertainment[2].data.push( aaa[i]);
                }

                results =  localStorage.getItem('tv2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesEntertainment[3].data.push( aaa[i]);
                }

                results =  localStorage.getItem('games1').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesEntertainment[4].data.push( aaa[i]);
                }

                results =  localStorage.getItem('games2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesEntertainment[5].data.push( aaa[i]);
                }

                results =  localStorage.getItem('userDetails2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 1;i<aaa.length;i++)
                {
                    this.userDetails1.push( aaa[i]);
                }

                results =  localStorage.getItem('userDetails1').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 1;i<aaa.length;i++)
                {
                    this.userDetails2.push( aaa[i]);
                }

                results =  localStorage.getItem('sleep1').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesRelaxation[0].data.push( aaa[i]);
                }

                results =  localStorage.getItem('sleep2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesRelaxation[1].data.push( aaa[i]);
                }

                results =  localStorage.getItem('travel1').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesRelaxation[2].data.push( aaa[i]);
                }

                results =  localStorage.getItem('travel2').replace("[","").replace("]","").replace(/(")/g, '')
                aaa = results.split(",");
                for(var i = 0;i<aaa.length;i++)
                {
                    this.seriesRelaxation[3].data.push( aaa[i]);
                }
              
              this.userName1= localStorage.getItem('userName');
              this.userName2= localStorage.getItem('userName2');
        }
         }
        
    }

</script>