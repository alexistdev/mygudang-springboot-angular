import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyMenuComponentComponent } from './my-menu-component.component';

describe('MyMenuComponentComponent', () => {
  let component: MyMenuComponentComponent;
  let fixture: ComponentFixture<MyMenuComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyMenuComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyMenuComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
